package me.cherepanov.spring.dao;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import me.cherepanov.spring.domain.Question;
import org.apache.commons.lang3.ArrayUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class QuestionsPoolCSVReader implements QuestionsPool {
    private final List<Question> questions = new ArrayList<Question>();

    private final String fileName;

    private InputStream csvInputStream;


    QuestionsPoolCSVReader(final String fileName) {
        this.fileName = fileName;
        init();
    }

    @Override
    public boolean init() {
        boolean result = false;


        try {
            CSVReader csvReader = getCSV();

            readQuestions(csvReader);
        } catch (Exception e) {
            e.printStackTrace();
        }


        return result;
    }

    private CSVReader getCSV() throws URISyntaxException, FileNotFoundException {
        URL csvURL = getClass().getClassLoader().getResource(fileName);

        File file = new File(csvURL.toURI());

        FileReader filereader = new FileReader(file);

        CSVReader csvReader = new CSVReader(filereader);
        return csvReader;
    }

    private void readQuestions(CSVReader csvReader) throws IOException, CsvValidationException {
        String[] questionRecord;
        while ((questionRecord = csvReader.readNext()) != null) {
            if (questionRecord.length > 3) {
                Question question = new Question(questionRecord[0], ArrayUtils.subarray(questionRecord, 1,
                        questionRecord.length - 1), questionRecord[questionRecord.length - 1]);
                questions.add(question);
            } else {
                System.out.println("Illegal line formas. Skipped...");
            }
        }
    }

    @Override
    public List<Question> getAll() {
        return questions;
    }
}
