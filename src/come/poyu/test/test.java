package come.poyu.test;

import come.poyu.constants.AppConstants;
import come.poyu.util.KeyedMd5;
import org.junit.Test;

public class test {
    @Test
    public void man()
    {
        String str  = KeyedMd5.getMd5Utf8("168poyu", AppConstants.MANAGER_PWD_KEY);
        System.out.println(str);
    }

}
