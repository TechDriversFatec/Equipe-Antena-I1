package com.fatec.antenas.service;

import com.fatec.antenas.model.DocumentCadi;
import com.fatec.antenas.repository.CadiRepository;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Base64;

public class CadiService {

    @Autowired
    private CadiRepository cadiRepository;

    public DocumentCadi ativaCadi(String b64) {
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(new String(Base64.getDecoder().decode(b64)));
            DocumentCadi cadi = cadiRepository.findByEmail(jsonObject.get("email").toString());
            if (cadi == null) {
                return null;
            }
            cadi.setAtivo(true);
            return cadiRepository.save(cadi);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
