package gov.iscc.MissionToMars.util;

/**
 * @Authour : Gagan Ahuja
 * This is the Master class that will insert all sample data
 */
public class MasterInsertion {
    public static void main(String[] args) {
        new InsertUsers().insertData();
        new InserCandidate().insertData();
        new InsertCargo().insertData();
        new InsertCountry().insertData();
        new InsertMission().insertData();
        new InsertQualification().insertData();
        new ShuttleIngestion().insertData();

    }
}
