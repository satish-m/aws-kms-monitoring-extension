package com.appdynamics.extensions.aws.dynamodb;

import static org.junit.Assert.assertTrue;

import java.util.Map;

import com.appdynamics.extensions.aws.kms.AWSKMSMonitor;
import org.junit.Test;

import com.google.common.collect.Maps;
import com.singularity.ee.agent.systemagent.api.TaskOutput;

public class AWSKMSMonitorITest {

    private AWSKMSMonitor classUnderTest = new AWSKMSMonitor();

    @Test
    public void testMetricsCollectionCredentialsEncrypted() throws Exception {
        Map<String, String> args = Maps.newHashMap();
        args.put("config-file", "src/test/resources/conf/itest-encrypted-config.yaml");

        TaskOutput result = classUnderTest.execute(args, null);
        assertTrue(result.getStatusMessage().contains("successfully completed"));
    }

    @Test
    public void testMetricsCollectionWithProxy() throws Exception {
        Map<String, String> args = Maps.newHashMap();
        args.put("config-file", "src/test/resources/conf/itest-proxy-config.yaml");

        TaskOutput result = classUnderTest.execute(args, null);
        assertTrue(result.getStatusMessage().contains("successfully completed"));
    }
}
