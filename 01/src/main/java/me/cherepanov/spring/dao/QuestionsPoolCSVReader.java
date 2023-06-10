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

public class QuestionsPoolCSVReader implements QuestionDAO {


    private final String fileName;

    private List<Question> questions = null;

    QuestionsPoolCSVReader(final String fileName) {
        this.fileName = fileName;

    }

    @Override
    public List<Question> getAll() {
        if (questions == null) {
            try {
                questions = new ArrayList<Question>();
                init();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return questions;
    }


    private boolean init() throws Exception {
        boolean result = false;
        CSVReader csvReader = null;
        InputStreamReader filereader = null;
        InputStream stream = null;
        try {
            stream = this.getClass().getClassLoader().getResourceAsStream(fileName);
            filereader = new InputStreamReader(stream);
            csvReader = new CSVReader(filereader);
            readQuestions(csvReader);
        } finally {
            if (csvReader != null) {
                csvReader.close();
            }
            if (filereader != null) {
                filereader.close();
            }
            if (stream != null) {
                stream.close();
            }
        }
        return result;
    }


    private void readQuestions(CSVReader csvReader) throws IOException, CsvValidationException {
        String[] questionRecord;
        while ((questionRecord = csvReader.readNext()) != null) {
            if (questionRecord.length > 3) {
                String questionText = questionRecord[0];
                String ritghtAnswer = questionRecord[questionRecord.length - 1];
                String[] answers = ArrayUtils.subarray(questionRecord, 1,
                        questionRecord.length - 1);
                List<AnswerOption> options = new ArrayList<AnswerOption>();
                for (int i = 0; i < answers.length; i++) {
                    options.add(new AnswerOption(answers[i], ritghtAnswer.equals(i)));
                }

                Question question = new Question(questionText, options);
                questions.add(question);
            } else {
                throw new IllegalStateException("Illegal line formats. Test Skipped...");
            }
        }
    }

}
