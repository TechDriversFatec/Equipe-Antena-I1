package com.fatec.antenas.service;

import com.fatec.antenas.model.DocumentAluno;
import com.fatec.antenas.repository.AlunoRepository;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Base64;

public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public DocumentAluno ativaAluno(String b64) {
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(new String(Base64.getDecoder().decode(b64)));
            DocumentAluno aluno = alunoRepository.findByEmail(jsonObject.get("email").toString());
            if (aluno == null) {
                return null;
            }
            aluno.setAtivo(true);
            return alunoRepository.save(aluno);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
