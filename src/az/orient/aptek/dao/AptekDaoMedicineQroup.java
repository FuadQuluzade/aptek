package az.orient.aptek.dao;

import java.util.List;

import az.orient.aptek.pojo.Anbar;
import az.orient.aptek.pojo.MedicineQroup;

public interface AptekDaoMedicineQroup {

    List<MedicineQroup> getMedicineQroupList() throws Exception;

    boolean addMedicineQroup(MedicineQroup medicineQroup) throws Exception;

    MedicineQroup getMedicineQroupById(Long medicineQroupId) throws Exception;

    boolean updateMedicineQroup(MedicineQroup medicineQroup, Long medicineQroupId) throws Exception;

    boolean deleteMedicineQroup(Long AnbarId) throws Exception;

    List<MedicineQroup> searchMedicineQroupData(String keyword) throws Exception;
    
    boolean checkMedicineQroup(MedicineQroup medicineQroup,boolean result) throws Exception;

}
