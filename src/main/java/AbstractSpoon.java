/**
 * Created with IntelliJ IDEA.
 * User: qatang
 * Date: 13-11-22
 * Time: 09:59
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractSpoon implements Cloneable{
    String spoonName;

    public void setSpoonName(String spoonName) {
        this.spoonName = spoonName;
    }
    public String getSpoonName() {return this.spoonName;}

    public Object clone(){
        Object object = null;
        try {
            object = super.clone();
        } catch (CloneNotSupportedException exception) {
            System.err.println("AbstractSpoon is not Cloneable");
        }
        return object;
    }
}
