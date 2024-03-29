package com.example.Controller.Employee;
import com.example.Controller.MODEL.Employe;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import java.util.Date;
import java.util.List;
import java.util.Map;

@ManagedBean(name ="employeeBean")
@RequestScoped
public class EmployeeBean {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaweb");
    private Employe employee;

    public EmployeeBean() {
        employee = new Employe(); // Instantiate a new Employee object
    }

    public Employe getEmployee() {
        return employee;
    }

    public void setEmployee(Employe employee) {
        this.employee = employee;
    }

    public String add() {
        Employe e = new Employe();
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        sessionMap.put("employee", e);
        return  "/add.xhtml";
    }



    public List<Employe> getEmployees() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Employe> query = em.createQuery("SELECT e FROM Employe e", Employe.class);
        List<Employe> listEmployees = query.getResultList();
        em.close();

        return listEmployees;
    }


    public String delete(Long id) {
        EntityManager em = emf.createEntityManager();
        Employe employee = em.find(Employe.class, id);
        em.getTransaction().begin();
        em.remove(employee);
        em.getTransaction().commit();
        em.close();

        System.out.println("Employee deleted");
        return "/list.xhtml";
    }
}

