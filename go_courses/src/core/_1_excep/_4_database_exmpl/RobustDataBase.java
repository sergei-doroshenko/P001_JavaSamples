package core._1_excep._4_database_exmpl;

/**
 * Created by Sergei on 27.02.2015.
 */
public class RobustDataBase {
    private DataBase firstDB;
    private DataBase secondDB;

    public void save(String info) throws DataBaseException {
        try {
            firstDB.save(info);
        } catch (DataBaseException exA) {
            // STRATEGY: catch and process
            try {
                secondDB.save(info);
            } catch (DataBaseException exB) {
                // STRATEGY: catch and rethrow old
                exA.addSuppressed(exB);
                throw exA;
            }
        }
    }
}
