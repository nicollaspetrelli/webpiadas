package dev.nicollas.webpiadas.domain;

import javax.persistence.*;

@Entity
@Table(name = "piadas")
public class Piada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String pergunta;
    private String resposta;

    public Piada(Integer id, String pergunta, String resposta) {
        this.id = id;
        this.pergunta = pergunta;
        this.resposta = resposta;
    }

    public Piada() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    @Override
    public String toString() {
        return "Piada{" +
                "id=" + id +
                ", pergunta='" + pergunta + '\'' +
                ", resposta='" + resposta + '\'' +
                '}';
    }
}
