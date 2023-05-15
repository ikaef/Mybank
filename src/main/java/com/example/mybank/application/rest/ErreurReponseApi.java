package com.example.mybank.application.rest;

import lombok.ToString;
import lombok.Value;

@Value
public class ErreurReponseApi {

    String erreur;

    String message;

    public static ErreurReponseApiBuilder builder() {
        return new ErreurReponseApiBuilder();
    }

    @ToString
    public static class ErreurReponseApiBuilder {

        private String erreur;
        private String message;

        ErreurReponseApiBuilder() {}

        public ErreurReponseApiBuilder erreur(String erreur) {
            this.erreur = erreur;
            return this;
        }

        public ErreurReponseApiBuilder erreur(ErreurApi erreurApi) {
            return this.erreur(erreurApi.name());
        }

        public ErreurReponseApiBuilder message(String message) {
            this.message = message;
            return this;
        }

        public ErreurReponseApi build() {
            return new ErreurReponseApi(erreur, message);
        }
    }
}