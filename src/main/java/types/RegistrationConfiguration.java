/*
Copyright (c) 2017 Red Hat, Inc.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRAN/TIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

package types;

import org.ovirt.api.metamodel.annotations.Link;
import org.ovirt.api.metamodel.annotations.Type;

/**
 * This type describes how an object (virtual machine, template,
 * etc) is registered, and is used for the implementation of disaster recovery solutions.
 *
 * Each mapping contained in this type can be used to map
 * objects in the original system to corresponding objects
 * in the system where the virtual machine or template is being registered.
 * For example, there could be a primary setup with a virtual machine
 * configured on cluster A, and an active secondary setup with cluster B.
 * Cluster B is compatible with that virtual machine, and in case of a
 * disaster recovery scenario the storage domain can be
 * imported to the secondary setup, and the user can register the
 * virtual machine to cluster B.
 *
 * In that case, we can automate the recovery process by defining a cluster mapping.
 * After the entity is registered, its OVF will indicate it belongs to
 * cluster A, but the mapping will indicate that cluster A will
 * be replaced with cluster B.
 * {engine-name} should do the switch and register the virtual machine to cluster B
 * in the secondary site.
 *
 * Cluster mapping is just one example, there are different types of mappings:
 *
 * - Cluster mapping.
 * - LUN mapping.
 * - Role mapping.
 * - Domain mapping.
 * - Permissions mapping.
 * - Affinity Group mapping.
 * - Affinity Label mapping.
 *
 * Each mapping will be used for its specific OVF's data once the register operation
 * takes place in the {engine-name}.
 *
 * An example of an XML representation using the mapping:
 *
 * [source,xml]
 * ----
 * <action>
 *   <registration_configuration>
 *     <cluster_mappings>
 *       <registration_cluster_mapping>
 *         <from>
 *           <name>myoriginalcluster</name>
 *         </from>
 *         <to>
 *           <name>mynewcluster</name>
 *         </to>
 *       </registration_cluster_mapping>
 *     </cluster_mappings>
 *     <role_mappings>
 *       <registration_role_mapping>
 *         <from>
 *           <name>SuperUser</name>
 *         </from>
 *         <to>
 *           <name>UserVmRunTimeManager</name>
 *         </to>
 *       </registration_role_mapping>
 *     </role_mappings>
 *     <domain_mappings>
 *       <registration_domain_mapping>
 *         <from>
 *           <name>redhat</name>
 *         </from>
 *         <to>
 *           <name>internal</name>
 *         </to>
 *       </registration_domain_mapping>
 *     </domain_mappings>
 *     <lun_mappings>
 *       <registration_lun_mapping>
 *         <from id="418de86e-09b4-47b4-a923-419e7f5bd803">
 *         </from>
 *         <to id="418de86e-09b4-47b4-a923-419e7f5bd803">
 *           <alias>weTestLun</alias>
 *           <lun_storage>
 *             <type>iscsi</type>
 *             <logical_units>
 *               <logical_unit id="36001405fb1ddb4b91e44078b10f8cde2">
 *                 <product_id>fileio12</product_id>
 *                 <vendor_id>LIO-ORG</vendor_id>
 *                 <lun_mapping>1</lun_mapping>
 *                 <discard_max_size>4194304</discard_max_size>
 *                 <discard_zeroes_data>false</discard_zeroes_data>
 *                 <serial>SLIO-ORG_fileio12_e546cafa-7546-4816-8b9f-609cbc938c94</serial>
 *                 <physical_volume_id>4194304</physical_volume_id>
 *                 <size>5368709120</size>
 *                 <address>10.35.16.55</address>
 *                 <port>3260</port>
 *                 <portal>1</portal>
 *                 <target>iqn.2015-07.com.mlipchuk6.redhat:444</target>
 *               </logical_unit>
 *             </logical_units>
 *           </lun_storage>
 *         </to>
 *       </registration_lun_mapping>
 *     </lun_mappings>
 *     <affinity_group_mappings>
 *      <registration_affinity_group_mapping>
 *        <from>
 *          <name>affinity</name>
 *        </from>
 *        <to>
 *          <name>affinity2</name>
 *        </to>
 *      </registration_affinity_group_mapping>
 *     </affinity_group_mappings>
 *     <affinity_label_mappings>
 *      <registration_affinity_label_mapping>
 *        <from>
 *          <name>affinity_label</name>
 *        </from>
 *        <to>
 *          <name>affinity_label2</name>
 *        </to>
 *      </registration_affinity_label_mapping>
 *     </affinity_label_mappings>
 *   </registration_configuration>
 * </action>
 * ----
 *
 * @author Maor Lipchuk <mlipchuk@redhat.com>
 * @author Byron Gravenorst <bgraveno@redhat.com>
 * @date 20 Oct 2017
 * @status updated_by_docs
 * @since 4.2
 */
@Type
public interface RegistrationConfiguration {
    /**
     * Describes how the clusters that the object references are
     * mapped.
     *
     * @author Maor Lipchuk <mlipchuk@redhat.com>
     * @author Byron Gravenorst <bgraveno@redhat.com>
     * @date 20 Oct 2017
     * @status updated_by_docs
     * @since 4.2
     */
    RegistrationClusterMapping[] clusterMappings();

    /**
     * Describes how the roles are mapped.
     *
     * @author Maor Lipchuk <mlipchuk@redhat.com>
     * @author Byron Gravenorst <bgraveno@redhat.com>
     * @date 20 Oct 2017
     * @status updated_by_docs
     * @since 4.2
     */
    RegistrationRoleMapping[] roleMappings();

    /**
     * Describes how the LUNs are mapped.
     *
     * @author Maor Lipchuk <mlipchuk@redhat.com>
     * @author Byron Gravenorst <bgraveno@redhat.com>
     * @date 20 Oct 2017
     * @status updated_by_docs
     * @since 4.2
     */
    RegistrationLunMapping[] lunMappings();

    /**
     * Describes how the users' domains are mapped.
     *
     * @author Maor Lipchuk <mlipchuk@redhat.com>
     * @author Byron Gravenorst <bgraveno@redhat.com>
     * @date 20 Oct 2017
     * @status updated_by_docs
     * @since 4.2
     */
    RegistrationDomainMapping[] domainMappings();

    /**
     * Describes how the affinity groups are mapped.
     *
     * @author Maor Lipchuk <mlipchuk@redhat.com>
     * @author Byron Gravenorst <bgraveno@redhat.com>
     * @date 20 Oct 2017
     * @status updated_by_docs
     * @since 4.2
     */
    RegistrationAffinityGroupMapping[] affinityGroupMappings();

    /**
     * Describes how the affinity labels are mapped.
     *
     * @author Maor Lipchuk <mlipchuk@redhat.com>
     * @author Byron Gravenorst <bgraveno@redhat.com>
     * @date 20 Oct 2017
     * @status updated_by_docs
     * @since 4.2
     */
    RegistrationAffinityLabelMapping[] affinityLabelMappings();
}
