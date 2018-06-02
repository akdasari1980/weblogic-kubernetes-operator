// Copyright 2018, Oracle Corporation and/or its affiliates.  All rights reserved.
// Licensed under the Universal Permissive License v 1.0 as shown at
// http://oss.oracle.com/licenses/upl.

package oracle.kubernetes.operator.create;

import static oracle.kubernetes.operator.utils.CreateDomainInputs.*;
import static oracle.kubernetes.operator.utils.KubernetesArtifactUtils.*;
import static oracle.kubernetes.operator.utils.YamlUtils.yamlEqualTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import io.kubernetes.client.models.V1Job;
import io.kubernetes.client.models.V1PersistentVolume;
import oracle.kubernetes.operator.utils.CreateDomainInputs;
import oracle.kubernetes.operator.utils.ParsedVoyagerOperatorYaml;
import oracle.kubernetes.weblogic.domain.v1.Domain;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Tests that the all artifacts in the yaml files that create-weblogic-domain.sh creates are correct
 * when the load balancer is voyager.
 */
public class CreateDomainGeneratedFilesVoyagerTest
    extends CreateDomainGeneratedFilesOptionalFeaturesEnabledTest {

  @BeforeClass
  public static void setup() throws Exception {
    setup(
        CreateDomainInputs.newInputs()
            .exposeAdminNodePort("true")
            .exposeAdminT3Channel("true")
            .clusterType("CONFIGURED")
            .weblogicImagePullSecretName("test-weblogic-image-pull-secret-name")
            .loadBalancer(LOAD_BALANCER_VOYAGER)
            .loadBalancerAppPrepath("/loadBalancerAppPrePath")
            .loadBalancerExposeAdminPort("false")
            .weblogicDomainStorageType(STORAGE_TYPE_NFS)
            .productionModeEnabled("true"));
  }

  @Test
  @Override
  public void generatesCorrect_loadBalancerDeployment() throws Exception {
    assertThat(getActualVoyagerDeployment(), yamlEqualTo(getExpectedVoyagerDeployment()));
  }

/*
  @Test
  public void generatesCorrect_loadBalancerSecret() throws Exception {
    assertThat(getActualVoyagerSecret(), yamlEqualTo(getExpectedVoyagerSecret()));
  }
*/

  @Test
  @Override
  public void generatesCorrect_loadBalancerService() throws Exception {
    assertThat(getActualVoyagerService(), yamlEqualTo(getExpectedVoyagerService())); //voyager-operator
  }

  @Test
  public void generatesCorrect_loadBalancerAPIService() throws Exception {
    assertThat(getActualVoyagerAPIService(), yamlEqualTo(getExpectedVoyagerAPIService()));
  }

  @Test
  @Override
  public void generatesCorrect_loadBalancerServiceAccount() throws Exception {
    assertThat(getActualVoyagerServiceAccount(), yamlEqualTo(getExpectedVoyagerServiceAccount()));
  }

  @Test
  @Override
  public void generatesCorrect_loadBalancerClusterRole() throws Exception {
    assertThat(getActualVoyagerClusterRole(), yamlEqualTo(getExpectedVoyagerClusterRole())); //voyager-operator
  }

  @Test
  @Override
  public void generatesCorrect_loadBalancerClusterRoleBinding() throws Exception {
    assertThat(
        getActualVoyagerClusterRoleBinding(), yamlEqualTo(getExpectedVoyagerClusterRoleBinding())); //voyager-operator
  }

  @Test
  public void generatesCorrect_loadBalancerAuthenticationReaderRoleBinding() throws Exception {
    assertThat(
        getActualVoyagerAuthenticationReaderRoleBinding(), yamlEqualTo(getExpectedVoyagerAuthenticationReaderRoleBinding())); //voyager-apiserver-extension-server-authentication-reader
  }

  @Test
  public void generatesCorrect_loadBalancerClusterRoleBinding1() throws Exception {
    assertThat(
        getActualVoyagerClusterRoleBinding(), yamlEqualTo(getExpectedVoyagerClusterRoleBinding())); //voyager-apiserver-auth-delegator
  }
/*
  @Override
  public void generatesCorrect_loadBalancerClusterRole1() throws Exception {
    assertThat(getActualVoyagerClusterRole(), yamlEqualTo(getExpectedVoyagerClusterRole())); //appscode:voyager:edit
  }

  @Override
  public void generatesCorrect_loadBalancerClusterRole2() throws Exception {
    assertThat(getActualVoyagerClusterRole(), yamlEqualTo(getExpectedVoyagerClusterRole())); //appscode:voyager:view
  }

  @Override
  public void generatesCorrect_loadBalancerIngress() throws Exception {
    assertThat(getActualVoyagerIngress(), yamlEqualTo(getExpectedVoyagerIngress()));
  }

  @Override
  public void generatesCorrect_loadBalancerService1() throws Exception {
    assertThat(getActualVoyagerService(), yamlEqualTo(getExpectedVoyagerService())); //domain1-voyager-stats
  }
*/
  @Override
  public void loadBalancerSecurityYaml_hasCorrectNumberOfObjects() throws Exception {
    assertThat(
        getVoyagerOperatorSecurityYaml().getObjectCount(),
        is(getVoyagerOperatorSecurityYaml().getExpectedObjectCount()));
  }

  @Override
  public void loadBalancerYaml_hasCorrectNumberOfObjects() throws Exception {
    assertThat(getVoyagerOperatorYaml().getObjectCount(), is(getVoyagerOperatorYaml().getExpectedObjectCount()));
  }
/*
  @Override
  public void loadBalancerIngressYaml_hasCorrectNumberOfObjects() throws Exception {
    assertThat(getVoyagerIngressYaml().getObjectCount(), is(getVoyagerIngressYaml().getExpectedObjectCount()));
  }
*/
}
