package domain;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;
import java.io.Serializable;

@Embeddable
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@EqualsAndHashCode
public class StudentCareerPK implements Serializable{
	
	@Column( name = "id")
    private Integer id;
    @Column( name = "dni")
    private Long dni;

}

