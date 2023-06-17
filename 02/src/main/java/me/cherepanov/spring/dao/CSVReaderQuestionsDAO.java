package me.cherepanov.spring.dao;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import me.cherepanov.spring.domain.AnswerOption;
import me.cherepanov.spring.domain.Question;
import org.apache.commons.lang3.ArrayUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CSVReaderQuestionsDAO implements QuestionsDAO {


    private final String fileName;



    public CSVReaderQuestionsDAO(final String fileName) {
        this.fileName = fileName;

    }

    @Override
    public List<Question> getAll() {

            try {

                try (InputStream stream = this.getClass().getClassLoader().getResourceAsStream(fileName);
                     InputStreamReader filereader = new InputStreamReader(stream);
                     CSVReader csvReader = new CSVReader(filereader)) {
                   return readQuestions(csvReader);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
    }

    private List<Question> readQuestions(CSVReader csvReader) throws IOException, CsvValidationException {
        List<Question> questions = new ArrayList<>();
        String[] questionRecord;
        while ((questionRecord = csvReader.readNext()) != null) {
            if (questionRecord.length > 3) {
                String questionText = questionRecord[0];
                String ritghtAnswer = questionRecord[questionRecord.length - 1];
                String[] answers = ArrayUtils.subarray(questionRecord, 1,
                        questionRecord.length - 1);
                List<AnswerOption> options = new ArrayList<>();
                for (int i = 0; i < answers.length; i++) {
                    options.add(new AnswerOption(answers[i], answers[i].startsWith(ritghtAnswer)));
                }

                Question question = new Question(questionText, options);
                questions.add(question);
            } else {
                throw new IllegalStateException("Illegal line formats. Test Skipped...");
            }
        }
        return questions;
    }

}
