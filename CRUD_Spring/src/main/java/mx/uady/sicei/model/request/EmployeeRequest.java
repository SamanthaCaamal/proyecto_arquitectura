package mx.uady.sicei.model.request;

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
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return String return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return String return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return int return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
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
