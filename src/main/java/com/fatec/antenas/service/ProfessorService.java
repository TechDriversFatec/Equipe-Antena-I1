package com.fatec.antenas.service;

import com.fatec.antenas.model.DocumentProfessor;
import com.fatec.antenas.repository.ProfessorRepository;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Base64;

public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    public DocumentProfessor ativaProfessor(String b64) {
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(new String(Base64.getDecoder().decode(b64)));
            DocumentProfessor professor = professorRepository.findByEmail(jsonObject.get("email").toString());
            if (professor == null) {
                return null;
            }
            professor.setAtivo(true);
            return professorRepository.save(professor);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
