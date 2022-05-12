package com.upgrad.patterns.Service;

import com.upgrad.patterns.Interfaces.IndianDiseaseStat;
import com.upgrad.patterns.Constants.SourceType;
import com.upgrad.patterns.Strategies.DiseaseShStrategy;
import com.upgrad.patterns.Strategies.JohnHopkinsStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndiaDiseaseStatFactory {
    private IndianDiseaseStat diseaseShStrategy;
    private IndianDiseaseStat johnHopkinsStrategy;

    @Autowired
    public IndiaDiseaseStatFactory(DiseaseShStrategy diseaseShStrategy, JohnHopkinsStrategy johnHopkinsStrategy)
    {
        this.diseaseShStrategy = diseaseShStrategy;
        this.johnHopkinsStrategy = johnHopkinsStrategy;
    }

    
    //create a method named GetInstance with return type as IndianDiseaseStat and parameter of type sourceType
    public IndianDiseaseStat GetInstance(SourceType sourceType) {
        //create a conditional statement
        switch (sourceType) {
            //if the sourceType is JohnHopkins
            case JohnHopkins:
                //return johnHopkinsStrategy
                return new JohnHopkinsStrategy();
            //if the sourceType is DiseaseSh
            case DiseaseSh:
                //return diseaseShStrategy
                return new DiseaseShStrategy();
            //create a message for invalid disease strategy/sourceType
            default:
                String message = "Invalid disease strategy/sourceType";
                //throw the message as an Illegal argument exception
                throw new IllegalArgumentException(message);
        }
    }
    
}
