package org.launchcode.liftoffproject.models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name="comment")
public class Comment extends AbstractEntity {

    @NotBlank(message = "Comment cannot be blank.")
    @Size(max = 1000, message = "Comment cannot exceed 1000 characters.")
    @Column(name="user_input")
    private String userInput;

    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    @Column(name="posted_date")
    private Date postedDate;

    @ManyToOne
    private Intervention intervention;

    public Comment() {}

    public Comment(String userInput, Date postedDate, Intervention intervention) {

        this.userInput = userInput;
        this.postedDate = postedDate;
        this.intervention = intervention;
    }


    public String getUserInput() {
        return userInput;
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }

    public Date getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(Date postedDate) {
        this.postedDate = postedDate;
    }

    public Intervention getIntervention() {
        return intervention;
    }

    public void setIntervention(Intervention intervention) {
        this.intervention = intervention;
    }

    @Override
    public String toString() {
        return userInput;
    }

}

