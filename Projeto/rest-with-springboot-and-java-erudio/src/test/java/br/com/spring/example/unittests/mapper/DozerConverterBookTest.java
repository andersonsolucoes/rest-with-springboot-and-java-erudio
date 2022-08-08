package br.com.spring.example.unittests.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.spring.example.data.vo.v1.BookVO;
import br.com.spring.example.mapper.DozerMapper;
import br.com.spring.example.model.Book;
import br.com.spring.example.unittests.mapper.mocks.MockBook;

public class DozerConverterBookTest {
    
    MockBook inputObject;

    @BeforeEach
    public void setUp() {
        inputObject = new MockBook();
    }

    @Test
    public void parseEntityToVOTest() {
        BookVO output = DozerMapper.parseObject(inputObject.mockEntity(), BookVO.class);
        assertEquals(Long.valueOf(0L), output.getKey());
        assertEquals("Author Test0", output.getAuthor());
        assertEquals("Title Test0", output.getTitle());
        assertNotNull(output.getLaunchDate());
        assertEquals(new BigDecimal(0), output.getPrice());
    }

    @Test
    public void parseEntityListToVOListTest() {
        List<BookVO> outputList = DozerMapper.parseListObjects(inputObject.mockEntityList(), BookVO.class);
        BookVO outputZero = outputList.get(0);
        
        assertEquals(Long.valueOf(0L), outputZero.getKey());
        assertEquals("Author Test0", outputZero.getAuthor());
        assertEquals("Title Test0", outputZero.getTitle());
        assertNotNull(outputZero.getLaunchDate());
        assertEquals(new BigDecimal(0), outputZero.getPrice());
        
        BookVO outputSeven = outputList.get(7);
        
        assertEquals(Long.valueOf(7L), outputSeven.getKey());
        assertEquals("Author Test7", outputSeven.getAuthor());
        assertEquals("Title Test7", outputSeven.getTitle());
       
        assertNotNull(outputSeven.getLaunchDate());
        assertEquals(new BigDecimal(7), outputSeven.getPrice());
        
        BookVO outputTwelve = outputList.get(12);
        
        assertEquals(Long.valueOf(12L), outputTwelve.getKey());
        assertEquals("Author Test12", outputTwelve.getAuthor());
        assertEquals("Title Test12", outputTwelve.getTitle());
        
        assertNotNull(outputTwelve.getLaunchDate());
        assertEquals(new BigDecimal(12), outputTwelve.getPrice());
    }

    @Test
    public void parseVOToEntityTest() {
        Book output = DozerMapper.parseObject(inputObject.mockVO(), Book.class);
        assertEquals(Long.valueOf(0L), output.getId());
        assertEquals("Author Test0", output.getAuthor());
        assertEquals("Title Test0", output.getTitle());
        assertNotNull(output.getLaunchDate());
        assertEquals(new BigDecimal(0), output.getPrice());
    }

    @Test
    public void parserVOListToEntityListTest() {
        List<Book> outputList = DozerMapper.parseListObjects(inputObject.mockVOList(), Book.class);
        Book outputZero = outputList.get(0);
        
        assertEquals(Long.valueOf(0L), outputZero.getId());
        assertEquals("Author Test0", outputZero.getAuthor());
        assertEquals("Title Test0", outputZero.getTitle());
        assertNotNull(outputZero.getLaunchDate());
        assertEquals(new BigDecimal(0), outputZero.getPrice());
        
        Book outputSeven = outputList.get(7);
        
        assertEquals(Long.valueOf(7L), outputSeven.getId());
        assertEquals("Author Test7", outputSeven.getAuthor());
        assertEquals("Title Test7", outputSeven.getTitle());
        
        assertNotNull(outputSeven.getLaunchDate());
        assertEquals(new BigDecimal(7), outputSeven.getPrice());
        
        Book outputTwelve = outputList.get(12);
        
        assertEquals(Long.valueOf(12L), outputTwelve.getId());
        assertEquals("Author Test12", outputTwelve.getAuthor());
        assertEquals("Title Test12", outputTwelve.getTitle());
       
        assertNotNull(outputTwelve.getLaunchDate());
        assertEquals(new BigDecimal(12), outputTwelve.getPrice());
    }
}
