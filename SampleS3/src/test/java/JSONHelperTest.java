
import com.imos.sample.JSONHelper;
import com.imos.sample.S3Constant;
import static com.imos.sample.S3Constant.ACCOUNT_ID;
import static com.imos.sample.S3Constant.ANALYSIS_ID;
import static com.imos.sample.S3Constant.DATA;
import static com.imos.sample.S3Constant.EVENT;
import static com.imos.sample.S3Constant.NUM_FAILED_RULES;
import static com.imos.sample.S3Constant.NUM_OF_ELEMENTS;
import static com.imos.sample.S3Constant.NUM_OF_RULES;
import static com.imos.sample.S3Constant.PROJECT_ID;
import static com.imos.sample.S3Constant.SYSTEM;
import static com.imos.sample.S3Constant.TIME;
import static com.imos.sample.S3Constant.TIMESTAMP;
import static com.imos.sample.S3Constant.USER_ID;
import static com.imos.sample.S3Constant.VERSION;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alok
 */
public final class JSONHelperTest {

    private JSONHelper helper;
    
    @Before
    public void setUp() {
        helper = new JSONHelper();
    }
    
    @Test
    public void checkSignInJSON() {
        
        JSONObject data = new JSONObject(helper.createSigninJSON());
        
        Assert.assertNotEquals("{}", data.toString());
        
        System.out.println(helper.createSigninJSON());
    }
    
    @Test
    public void checkSignInVersion() {
        
        JSONObject data = new JSONObject(helper.createSigninJSON());
        
        Assert.assertTrue(data.has(VERSION));
    }
    
    @Test
    public void checkSignInTimestamp() {
        
        JSONObject data = new JSONObject(helper.createSigninJSON());
        
        Assert.assertTrue(data.has(TIMESTAMP));
    }
    
    @Test
    public void checkSignInSystem() {
        
        JSONObject data = new JSONObject(helper.createSigninJSON());
        
        Assert.assertTrue(data.has(SYSTEM));
    }
    
    @Test
    public void checkSignInTime() {
        
        JSONObject data = new JSONObject(helper.createSigninJSON());
        
        Assert.assertTrue(data.getJSONObject(SYSTEM).has(TIME));
    }
    
    @Test
    public void checkSignInEvent() {
        
        JSONObject data = new JSONObject(helper.createSigninJSON());
        
        Assert.assertTrue(data.getJSONObject(SYSTEM).has(EVENT));
    }
    
    @Test
    public void checkSignInData() {
        
        JSONObject data = new JSONObject(helper.createSigninJSON());
        
        Assert.assertTrue(data.has(DATA));
    }
    
    @Test
    public void checkSignInUserId() {
        
        JSONObject data = new JSONObject(helper.createSigninJSON());
        
        Assert.assertTrue(data.getJSONObject(DATA).has(USER_ID));
    }
    
    @Test
    public void checkSignInAccountId() {
        
        JSONObject data = new JSONObject(helper.createSigninJSON());
        
        Assert.assertTrue(data.getJSONObject(DATA).has(ACCOUNT_ID));
    }
    
    @Test
    public void checkAnalysisJSON() {
        
        JSONObject data = new JSONObject(helper.createAnalysisJSON());
        
        Assert.assertNotEquals("{}", data.toString());
        
        System.out.println(helper.createAnalysisJSON());
    }
    
    @Test
    public void checkAnalysisInVersion() {
        
        JSONObject data = new JSONObject(helper.createAnalysisJSON());
        
        Assert.assertTrue(data.has(VERSION));
    }
    
    @Test
    public void checkAnalysisTimestamp() {
        
        JSONObject data = new JSONObject(helper.createAnalysisJSON());
        
        Assert.assertTrue(data.has(TIMESTAMP));
    }
    
    @Test
    public void checkAnalysisSystem() {
        
        JSONObject data = new JSONObject(helper.createAnalysisJSON());
        
        Assert.assertTrue(data.has(SYSTEM));
    }
    
    @Test
    public void checkAnalysisTime() {
        
        JSONObject data = new JSONObject(helper.createAnalysisJSON());
        
        Assert.assertTrue(data.getJSONObject(SYSTEM).has(TIME));
    }
    
    @Test
    public void checkAnalysisEvent() {
        
        JSONObject data = new JSONObject(helper.createAnalysisJSON());
        
        Assert.assertTrue(data.getJSONObject(SYSTEM).has(EVENT));
    }
    
    @Test
    public void checkAnalysisData() {
        
        JSONObject data = new JSONObject(helper.createAnalysisJSON());
        
        Assert.assertTrue(data.has(DATA));
    }
    
    @Test
    public void checkAnalysisProjectId() {
        
        JSONObject data = new JSONObject(helper.createAnalysisJSON());
        
        Assert.assertTrue(data.getJSONObject(DATA).has(PROJECT_ID));
    }
    
    @Test
    public void checkAnalysisAccountId() {
        
        JSONObject data = new JSONObject(helper.createAnalysisJSON());
        
        Assert.assertTrue(data.getJSONObject(DATA).has(ACCOUNT_ID));
    }
    
    @Test
    public void checkAnalysisAnalysisId() {
        
        JSONObject data = new JSONObject(helper.createAnalysisJSON());
        
        Assert.assertTrue(data.getJSONObject(DATA).has(ANALYSIS_ID));
    }
    
    @Test
    public void checkAnalysisNumOfEements() {
        
        JSONObject data = new JSONObject(helper.createAnalysisJSON());
        
        Assert.assertTrue(data.getJSONObject(DATA).has(NUM_OF_ELEMENTS));
    }
    
    @Test
    public void checkAnalysisNumOfRules() {
        
        JSONObject data = new JSONObject(helper.createAnalysisJSON());
        
        Assert.assertTrue(data.getJSONObject(DATA).has(NUM_OF_RULES));
    }
    
    @Test
    public void checkAnalysisNumOfFailedEements() {
        
        JSONObject data = new JSONObject(helper.createAnalysisJSON());
        
        Assert.assertTrue(data.getJSONObject(DATA).has(S3Constant.NUM_FAILED_ELEMENTS));
    }
    
    @Test
    public void checkAnalysisNumOfFailedRules() {
        
        JSONObject data = new JSONObject(helper.createAnalysisJSON());
        
        Assert.assertTrue(data.getJSONObject(DATA).has(NUM_FAILED_RULES));
    }
}
