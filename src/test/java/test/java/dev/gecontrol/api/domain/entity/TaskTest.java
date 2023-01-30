package test.java.dev.gecontrol.api.domain.entity;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;

import dev.gecontrol.api.domain.entity.Task;
import dev.gecontrol.api.domain.entity.User;
import dev.gecontrol.api.domain.vo.*;

public class TaskTest {
    Name name = new Name("John", "Smith");
    Email email = new Email("john.smith@example.com");
    Password password = new Password("password123");
    UserPermission permissions = UserPermission.ADMIN;
    User user = new User(name, email, password, permissions);

    @Test
    void testTaskCreation() {
        Task task = new Task("Test Task", "Task details", user);
        
        assertEquals("Test Task", task.getName());
        assertEquals("Task details", task.getDetails());
        assertEquals(StatusTask.BACKLOG, task.getStatus());
        assertEquals(Priority.UNKNOW, task.getPriority());
        assertEquals(user, task.getAssignerTo());
        assertEquals(LocalDate.now(), task.getCreateDate());
        assertEquals(LocalDate.of(2999, 01, 01), task.getCompleteDate());
    }
    
    @Test
    void testSetters() {
        Task task = new Task("Test Task", "Task details", user);
        
        task.setName("New name");
        task.setDetails("New details");
        task.setStatus(StatusTask.INPROGRESS);
        task.setPriority(Priority.HIGH);
        task.setCreateDate(LocalDate.of(2022, 01, 01));
        task.setCompleteDate(LocalDate.of(2022, 12, 31));
        
        assertEquals("New name", task.getName());
        assertEquals("New details", task.getDetails());
        assertEquals(StatusTask.INPROGRESS, task.getStatus());
        assertEquals(Priority.HIGH, task.getPriority());
        assertEquals(user, task.getAssignerTo());
        assertEquals(LocalDate.of(2022, 01, 01), task.getCreateDate());
        assertEquals(LocalDate.of(2022, 12, 31), task.getCompleteDate());
    }
    
    @Test
    void testMarkComplete() {
        Task task = new Task("Test Task", "Task details", user);
        
        task.markComplete();
        
        assertEquals(StatusTask.COMPLETED, task.getStatus());
    }
    
    @Test
    void testUpdateDetails() {
        Task task = new Task("Test Task", "Task details", user);
        
        task.updateDetails("New details");
        
        assertEquals("New details", task.getDetails());
    }
    
}