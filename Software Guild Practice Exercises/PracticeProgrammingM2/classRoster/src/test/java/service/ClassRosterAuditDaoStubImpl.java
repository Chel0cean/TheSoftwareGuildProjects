
package service;

import dao.ClassRosterAuditDao;
import dao.ClassRosterPersistenceException;

/**
 *
 * @author chelseamiller
 */
public class ClassRosterAuditDaoStubImpl implements ClassRosterAuditDao {

    @Override
    public void writeAuditEntry(String entry) throws ClassRosterPersistenceException {
        //do nothing . . .
    }
}