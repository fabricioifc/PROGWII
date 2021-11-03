package controller;

import java.io.Serializable;
import java.sql.SQLException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import model.Usuario;
import repository.UsuarioRepository;

@ManagedBean(name = "login")
@RequestScoped
public class LoginController implements Serializable {

    private String email;
    private String senha;

//    Repositorio
    private final UsuarioRepository repository;

    public LoginController() {
        repository = new UsuarioRepository();
    }

    public String login() {
        try {
            // IMPLEMENTAR
//            return "restrito/dashboard.xhtml";
            throw new UnsupportedOperationException("IMPLEMENTAR ESSE METODO.");
        } catch (Exception ex) {
            ex.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ERRO", "Erro ao efetuar login!"));
            return null;
        }

    }

    public String logout() {
        try {
            HttpSession sessao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            sessao.invalidate();
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ERRO", "Erro ao efetuar login!"));

        }
        return "/index";
    }

    public Usuario getUsuarioLogado() throws Exception {
        try {
            // IMPLEMENTAR
//            throw new UnsupportedOperationException("IMPLEMENTAR ESSE METODO.");
            return null;
        } catch (Exception ex) {
            ex.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ERRO", "Erro ao efetuar login!"));
            throw ex;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
