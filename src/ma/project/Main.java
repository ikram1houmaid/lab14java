package ma.project;

import ma.project.entities.Machine;
import ma.project.entities.Salle;
import ma.project.service.MachineService;
import ma.project.service.SalleService;

import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        SalleService salleService = new SalleService();
        MachineService machineService = new MachineService();

        Salle s1 = new Salle(1, "A1", "Salle Informatique");
        Salle s2 = new Salle(2, "B2", "Salle Reseau");

        salleService.ajouter(s1);
        salleService.ajouter(s2);

        Machine m1 = new Machine(1, "PC-DELL-01", new Date(), s1);
        Machine m2 = new Machine(2, "PC-HP-02", new Date(), s1);
        Machine m3 = new Machine(3, "SERV-IBM-01", new Date(), s2);

        machineService.ajouter(m1);
        machineService.ajouter(m2);
        machineService.ajouter(m3);

        System.out.println("--- Machines dans la salle A1 ---");

        List<Machine> machinesA1 =
                machineService.getMachinesBySalle(1);

        for (int i = 0; i < machinesA1.size(); i++) {
            System.out.println(machinesA1.get(i));
        }

        m1.setRef("PC-DELL-PRO");

        machineService.modifier(m1);

        System.out.println("\n--- Apres modification ---");
        System.out.println(machineService.getById(1));

        machineService.supprimer(m3);

        System.out.println("\n--- Liste apres suppression ---");

        List<Machine> toutes = machineService.getAll();

        for (int i = 0; i < toutes.size(); i++) {
            System.out.println(toutes.get(i));
        }
    }
}