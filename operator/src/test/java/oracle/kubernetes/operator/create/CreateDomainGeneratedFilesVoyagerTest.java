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

/**
 * Tests that the all artifacts in the yaml files that create-weblogic-domain.sh creates are correct
 * when the load balancer is voyager.
 */
public class CreateDomainGeneratedFilesVoyagerTest
    extends CreateDomainGeneratedFilesBaseTest {

  @BeforeClass
  public static void setup() throws Exception {
    setup(
        CreateDomainInputs.newInputs()
            .loadBalancer(LOAD_BALANCER_VOYAGER));
  }

/**
  @Override
  public void generatesCorrect_loadBalancerDeployment() throws Exception {
    assertThat(getActualVoyagerDeployment(), yamlEqualTo(getExpectedVoyagerDeployment()));
  }

  @Override
  public void generatesCorrect_loadBalancerSecret() throws Exception {
    assertThat(getActualVoyagerSecret(), yamlEqualTo(getExpectedVoyagerSecret()));
  }

  @Override
  public void generatesCorrect_loadBalancerService() throws Exception {
    assertThat(getActualVoyagerService(), yamlEqualTo(getExpectedVoyagerService())); //voyager-operator
  }

  @Override
  public void generatesCorrect_loadBalancerAPIService() throws Exception {
    assertThat(getActualVoyagerAPIService(), yamlEqualTo(getExpectedVoyagerAPIService()));
  }

  @Override
  public void generatesCorrect_loadBalancerServiceAccount() throws Exception {
    assertThat(getActualVoyagerServiceAccount(), yamlEqualTo(getExpectedVoyagerServiceAccount()));
  }

  @Override
  public void generatesCorrect_loadBalancerClusterRole() throws Exception {
    assertThat(getActualVoyagerClusterRole(), yamlEqualTo(getExpectedVoyagerClusterRole())); //voyager-operator
  }

  @Override
  public void generatesCorrect_loadBalancerClusterRoleBinding() throws Exception {
    assertThat(
        getActualVoyagerClusterRoleBinding(), yamlEqualTo(getExpectedVoyagerClusterRoleBinding())); //voyager-operator
  }

  @Override
  public void generatesCorrect_loadBalancerRoleBinding() throws Exception {
    assertThat(
        getActualVoyagerRoleBinding(), yamlEqualTo(getExpectedVoyagerRoleBinding())); //voyager-apiserver-extension-server-authentication-reader
  }

  @Override
  public void generatesCorrect_loadBalancerClusterRoleBinding1() throws Exception {
    assertThat(
        getActualVoyagerClusterRoleBinding(), yamlEqualTo(getExpectedVoyagerClusterRoleBinding())); //voyager-apiserver-auth-delegator
  }

  @Override
  public void generatesCorrect_loadBalancerClusterRole() throws Exception {
    assertThat(getActualVoyagerClusterRole(), yamlEqualTo(getExpectedVoyagerClusterRole())); //appscode:voyager:edit
  }

  @Override
  public void generatesCorrect_loadBalancerClusterRole() throws Exception {
    assertThat(getActualVoyagerClusterRole(), yamlEqualTo(getExpectedVoyagerClusterRole())); //appscode:voyager:view
  }

  @Override
  public void generatesCorrect_loadBalancerIngress() throws Exception {
    assertThat(getActualVoyagerIngress(), yamlEqualTo(getExpectedVoyagerIngress()));
  }

  @Override
  public void generatesCorrect_loadBalancerService() throws Exception {
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

  //@Override
  public void loadBalancerIngressYaml_hasCorrectNumberOfObjects() throws Exception {
    assertThat(getVoyagerIngressYaml().getObjectCount(), is(getVoyagerIngressYaml().getExpectedObjectCount()));
  }
}
