package sample;

public class Persona {
    private String name;
    private String death;
    private double age;

    public Persona(){
        this.name="";
        this.death="";
        this.age= 0;
    }

    public Persona(String name, String death, double age) throws PersonaException{
        this.name=name;
        this.death=death;
        this.age=age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeath() {
        return death;
    }

    public void setDeath(String death) {
        this.death = death;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        try{

            if(age<1){
                throw new PersonaException(PersonaException.BAD_AGE_LOWER);
            }
            if(age>120){
                throw new PersonaException(PersonaException.BAD_AGE_UPPER);
            }

            this.age = age;

        }catch (NumberFormatException | PersonaException er){
            try {
                throw new PersonaException(PersonaException.BAD_AGE);
            } catch (PersonaException personaException) {
                personaException.printStackTrace();
            }
        }
    }



}

