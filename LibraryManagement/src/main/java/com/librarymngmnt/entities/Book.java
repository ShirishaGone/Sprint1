package com.librarymngmnt.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Book {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="BookId")
    private Integer id;
	@Column(name="BookName")
    private String name;
	@Column(name="BookAuthor")
    private String author;
	@Column(name="BookYearOfPublication")
    private String yearofpublication;
	@Column(name="BookPrice")
    private String price;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="BookId",referencedColumnName="BookId")
    private Book book;
	 
  
}
