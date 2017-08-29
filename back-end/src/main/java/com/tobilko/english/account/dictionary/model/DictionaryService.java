package com.tobilko.english.account.dictionary.model;

import com.tobilko.english.account.dictionary.model.configuration.DictionaryServiceConfiguration;
import lombok.Data;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.net.URL;

/**
 * Created by Andrew Tobilko on 8/28/17.
 */
@Data
@Entity
public class DictionaryService {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String description;

    private URL logotype;

    @Embedded
    private DictionaryServiceConfiguration configuration;

}

class Random{

    public static void main(String[] args){

        java.util.Random obj = new java.util.Random();

        int n=10,sum=0,rand;

        for(int i=0; i<n; i++){
            rand = obj.nextInt();
            sum += rand;
            System.out.println("The number is: "+ rand);
            System.out.print("Start Pattern: ");
            for(int j=0; j<rand; j++)
                System.out.print("*");
        }
        System.out.println("\n Sum is : "+sum);
        System.out.println("Average is: "+(sum/n));
    }
}
