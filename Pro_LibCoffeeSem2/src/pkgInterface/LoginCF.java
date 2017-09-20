package pkgInterface;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author ng1an
 */
public interface LoginCF extends Remote {
    public boolean checkLogin(String lgUser , String lgPass , String lgPosition) throws RemoteException;
}
