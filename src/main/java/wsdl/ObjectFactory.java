
package wsdl;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the wsdl package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ValidatePhoneNoAndIdCardSame_QNAME = new QName("http://service.finance.hbmcc.huawei.com/", "validatePhoneNoAndIdCardSame");
    private final static QName _ValidatePhoneNoAndIdCardSameResponse_QNAME = new QName("http://service.finance.hbmcc.huawei.com/", "validatePhoneNoAndIdCardSameResponse");
    private final static QName _ValidatePhoneNoAndCustNameSame_QNAME = new QName("http://service.finance.hbmcc.huawei.com/", "validatePhoneNoAndCustNameSame");
    private final static QName _ValidatePhoneNoAndCustNameSameResponse_QNAME = new QName("http://service.finance.hbmcc.huawei.com/", "validatePhoneNoAndCustNameSameResponse");
    private final static QName _ValidatePhoneNoIdCardCustNameSame_QNAME = new QName("http://service.finance.hbmcc.huawei.com/", "validatePhoneNoIdCardCustNameSame");
    private final static QName _ValidatePhoneNoIdCardCustNameSameResponse_QNAME = new QName("http://service.finance.hbmcc.huawei.com/", "validatePhoneNoIdCardCustNameSameResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: wsdl
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ValidatePhoneNoAndIdCardSame }
     * 
     */
    public ValidatePhoneNoAndIdCardSame createValidatePhoneNoAndIdCardSame() {
        return new ValidatePhoneNoAndIdCardSame();
    }

    /**
     * Create an instance of {@link ValidatePhoneNoAndIdCardSameResponse }
     * 
     */
    public ValidatePhoneNoAndIdCardSameResponse createValidatePhoneNoAndIdCardSameResponse() {
        return new ValidatePhoneNoAndIdCardSameResponse();
    }

    /**
     * Create an instance of {@link ValidatePhoneNoAndCustNameSame }
     * 
     */
    public ValidatePhoneNoAndCustNameSame createValidatePhoneNoAndCustNameSame() {
        return new ValidatePhoneNoAndCustNameSame();
    }

    /**
     * Create an instance of {@link ValidatePhoneNoAndCustNameSameResponse }
     * 
     */
    public ValidatePhoneNoAndCustNameSameResponse createValidatePhoneNoAndCustNameSameResponse() {
        return new ValidatePhoneNoAndCustNameSameResponse();
    }

    /**
     * Create an instance of {@link ValidatePhoneNoIdCardCustNameSame }
     * 
     */
    public ValidatePhoneNoIdCardCustNameSame createValidatePhoneNoIdCardCustNameSame() {
        return new ValidatePhoneNoIdCardCustNameSame();
    }

    /**
     * Create an instance of {@link ValidatePhoneNoIdCardCustNameSameResponse }
     * 
     */
    public ValidatePhoneNoIdCardCustNameSameResponse createValidatePhoneNoIdCardCustNameSameResponse() {
        return new ValidatePhoneNoIdCardCustNameSameResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidatePhoneNoAndIdCardSame }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.finance.hbmcc.huawei.com/", name = "validatePhoneNoAndIdCardSame")
    public JAXBElement<ValidatePhoneNoAndIdCardSame> createValidatePhoneNoAndIdCardSame(ValidatePhoneNoAndIdCardSame value) {
        return new JAXBElement<ValidatePhoneNoAndIdCardSame>(_ValidatePhoneNoAndIdCardSame_QNAME, ValidatePhoneNoAndIdCardSame.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidatePhoneNoAndIdCardSameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.finance.hbmcc.huawei.com/", name = "validatePhoneNoAndIdCardSameResponse")
    public JAXBElement<ValidatePhoneNoAndIdCardSameResponse> createValidatePhoneNoAndIdCardSameResponse(ValidatePhoneNoAndIdCardSameResponse value) {
        return new JAXBElement<ValidatePhoneNoAndIdCardSameResponse>(_ValidatePhoneNoAndIdCardSameResponse_QNAME, ValidatePhoneNoAndIdCardSameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidatePhoneNoAndCustNameSame }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.finance.hbmcc.huawei.com/", name = "validatePhoneNoAndCustNameSame")
    public JAXBElement<ValidatePhoneNoAndCustNameSame> createValidatePhoneNoAndCustNameSame(ValidatePhoneNoAndCustNameSame value) {
        return new JAXBElement<ValidatePhoneNoAndCustNameSame>(_ValidatePhoneNoAndCustNameSame_QNAME, ValidatePhoneNoAndCustNameSame.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidatePhoneNoAndCustNameSameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.finance.hbmcc.huawei.com/", name = "validatePhoneNoAndCustNameSameResponse")
    public JAXBElement<ValidatePhoneNoAndCustNameSameResponse> createValidatePhoneNoAndCustNameSameResponse(ValidatePhoneNoAndCustNameSameResponse value) {
        return new JAXBElement<ValidatePhoneNoAndCustNameSameResponse>(_ValidatePhoneNoAndCustNameSameResponse_QNAME, ValidatePhoneNoAndCustNameSameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidatePhoneNoIdCardCustNameSame }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.finance.hbmcc.huawei.com/", name = "validatePhoneNoIdCardCustNameSame")
    public JAXBElement<ValidatePhoneNoIdCardCustNameSame> createValidatePhoneNoIdCardCustNameSame(ValidatePhoneNoIdCardCustNameSame value) {
        return new JAXBElement<ValidatePhoneNoIdCardCustNameSame>(_ValidatePhoneNoIdCardCustNameSame_QNAME, ValidatePhoneNoIdCardCustNameSame.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidatePhoneNoIdCardCustNameSameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.finance.hbmcc.huawei.com/", name = "validatePhoneNoIdCardCustNameSameResponse")
    public JAXBElement<ValidatePhoneNoIdCardCustNameSameResponse> createValidatePhoneNoIdCardCustNameSameResponse(ValidatePhoneNoIdCardCustNameSameResponse value) {
        return new JAXBElement<ValidatePhoneNoIdCardCustNameSameResponse>(_ValidatePhoneNoIdCardCustNameSameResponse_QNAME, ValidatePhoneNoIdCardCustNameSameResponse.class, null, value);
    }

}
