
package proxy;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour typeOperation.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <pre>{@code
 * <simpleType name="typeOperation">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <enumeration value="CREDIT"/>
 *     <enumeration value="DEBIT"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 * 
 */
@XmlType(name = "typeOperation")
@XmlEnum
public enum TypeOperation {

    CREDIT,
    DEBIT;

    public String value() {
        return name();
    }

    public static TypeOperation fromValue(String v) {
        return valueOf(v);
    }

}
