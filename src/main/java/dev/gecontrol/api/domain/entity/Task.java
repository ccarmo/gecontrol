package dev.gecontrol.api.domain.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import dev.gecontrol.api.domain.exceptions.TaskValidationException;
import dev.gecontrol.api.domain.vo.Priority;
import dev.gecontrol.api.domain.vo.StatusTask;

public class Task {
    private String name;
    private String details;
    private StatusTask status;
    private User assignerTo;
    private Priority priority;
    private LocalDate createDate;
    private LocalDate completeDate;

    public Task(String name, String details, User user) {
        this.name         = name;
        this.details      = details;
        this.status       = StatusTask.BACKLOG;
        this.priority     = Priority.UNKNOW;
        this.assignerTo   = user;
        this.createDate   = LocalDate.now();
        this.completeDate = LocalDate.of(2999, 01, 01);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setStatus(StatusTask status) {
        this.status = status;
    }

    public void setAssignUserTo(User user) {
        this.assignerTo = user;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }


    public void setCompleteDate(LocalDate completeDate) {
        this.completeDate = completeDate;
    }


    public String getName() {
        return name;
    }

    public String getDetails() {
        return details;
    }

    public StatusTask getStatus() {
        return status;
    }

    public User getAssignerTo() {
        return assignerTo;
    }

    public Priority getPriority() {
        return priority;
    }

    public LocalDate getCompleteDate() {
        return completeDate;
    }

    
    public LocalDate getCreateDate() {
        return createDate;
    }


    public void markComplete() {
        this.status = StatusTask.COMPLETED;
    }

    public void updateDetails(String newDetails) {
        this.details = newDetails;
    }


    private static <T> boolean isNotEmptyAndNotNull(T input) {
        if (input == null) {
            return false;
        }
    
        if (input instanceof String) {
            return !((String) input).isEmpty();
        } else if (input instanceof LocalDate) {
            return !((LocalDate) input).toString().isEmpty();
        } else if (input instanceof Collection) {
            return !((Collection) input).isEmpty();
        } else {
            return true;
        }
    }

        
    private void validate() throws TaskValidationException {
        List<String> errors = new ArrayList<>();
            
        if(isNotEmptyAndNotNull(name) && name.length() > 100) {
            errors.add("Name must be less than 100 characters.");
        }
            
        if(isNotEmptyAndNotNull(details) && details.length() > 1000) {
            errors.add("Details must be less than 1000 characters.");
        }
            
        if(completeDate != null && completeDate.isBefore(LocalDate.now())) {
            errors.add("Complete date must be in the future.");
        }

        if(createDate != null && createDate.isBefore(LocalDate.now())) {
            errors.add("Create date must be in the future.");
        }
            
        if(!errors.isEmpty()) {
            throw new TaskValidationException(errors);
        }
    }
}
