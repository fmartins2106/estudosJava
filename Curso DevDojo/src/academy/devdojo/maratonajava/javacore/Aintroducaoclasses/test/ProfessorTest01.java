package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.test;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Professor;

public class ProfessorTest01 {
    public static void main(String[] args) {
        Professor professor = new Professor();
        professor.nome = "Mestre Kami";
        professor.idade = 39;
        professor.sexo ='m';

        System.out.println("Nome: "+professor.nome+" Idade: "+professor.idade+" Sexo:"+professor.sexo);
    }
}
