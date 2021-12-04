package mx.uady.sicei.model.request;
/**
 * Una clase para realizar que almacena y valida que
 * los datos ingresados desde el sistema estén en el formato correcto y no estén vacíos.
 * @author Samantha Caamal, Montserrat Bustamante 
 */
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;

public class EmployeeRequest {
    @NotNull
    @Size(min = 5, max = 255)
    @NotEmpty
    @NotBlank(message = "Por favor, ingresar nombre del empleado")
    private String name;

    @Email(message = "Debe ser un correo válido")
    @NotNull
    @NotBlank(message = "Por favor, ingresar un correo electrónico")
    private String email;

    @Size(min = 1, max = 255)
    private String address;

    @Size(min = 10, max = 10, message = "El número telefónico debe ser de 10 caracteres")
    @NumberFormat(pattern = "#")
    private String phone;

    public EmployeeRequest() {

    }

    /**
     * @return String el Nombre del empleado
     */
    public String getName() {
        return name;
    }

    /**
     * @param name el Nombre del Empleado que se quiere registrar
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return String el correo electrónico del empleado
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email el correo electrónico del Empleado que se quiere registrar
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return String la dirección del Empleado 
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address la dirección del Empleado que se quiere registrar
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return String el número de teléfono del Empleado 
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone el número de teléfono del Empleado que se quiere registrar
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "{" + "name=" + getName() + "email=" + getEmail() + "address=" + getAddress() + "phone=" + getPhone()
                + "}";
    }
}
