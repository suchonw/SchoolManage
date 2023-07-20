package service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

class Start {
    public static void main(String[] data) {
        SpringApplication.run(Setup.class);
    }
}

@SpringBootApplication
class Setup {
    
    String connectionString = "jdbc:mysql://127.0.0.1/schooldb?user=adminschool&password=pass9";    
    
    @Bean 
    DriverManagerDataSource create() {
        return new DriverManagerDataSource(connectionString);
    }
}

@Table("student_info")
class Student_info {
    @Id public int id;
    public String name;
    public int grade;
    
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
}




