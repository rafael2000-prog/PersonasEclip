package ec.edu.ups.paw.demo66.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Usuario implements Serializable{
	
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_user")
	private int userId;
    private String name;
    private String direccion;
    private String telefono;
    private String correo;
    
    
    @OneToOne(cascade= {CascadeType.ALL})
    @JoinColumn(name="id_specialty")
    private Specialty specialty;
    
    @OneToOne(cascade= {CascadeType.ALL})
    @JoinColumn(name="id_role")
    private Role role;

    @OneToOne(cascade= {CascadeType.ALL})
    @JoinColumn(name="id_schedule")
    private Schedule schedule;
    
    @OneToMany(mappedBy="usuario")
    private List<Appointment> appointments;
   

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

	public Specialty getSpecialty() {
		return specialty;
	}

	public void setSpecialty(Specialty specialty) {
		this.specialty = specialty;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Usuario [userId=" + userId + ", name=" + name + ", direccion=" + direccion + ", telefono=" + telefono
				+ ", correo=" + correo + "]";
	}

	    

}
