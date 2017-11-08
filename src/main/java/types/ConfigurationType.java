/*
Copyright (c) 2015 Red Hat, Inc.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/
package types;

import org.ovirt.api.metamodel.annotations.Type;

/**
 * Configuration format types.
 *
 * @author Sharon Gratch <sgratch@redhat.com>
 * @author Tahlia Richardson <trichard@redhat.com>
 * @date 09 Nov 2017
 * @status updated_by_docs
 */
@Type
public enum ConfigurationType {
    /**
     * ConfigurationType of type oVirt-compatible OVF.
     *
     * The provided virtual machine configuration conforms with the oVirt-compatible form of the Open Virtualization
     * Format (OVF).
     * Note that the oVirt-compatible form of the OVF may differ from the OVF standard that is used by other vendors.
     * This value should be used for an OVF configuration that is taken from a storage domain.
     *
     * @author Sharon Gratch <sgratch@redhat.com>
     * @author Arik Hadas <ahadas@redhat.com>
     * @author Tahlia Richardson <trichard@redhat.com>
     * @date 09 Nov 2017
     * @status updated_by_docs
     */
    OVF,

    /**
     * ConfigurationType of type standard OVF.
     *
     * The provided virtual machine configuration conforms with the Open Virtualization Format (OVF) standard.
     * This value should be used for an OVF configuration that is extracted from an Open Virtual Appliance (OVA) that
     * was generated by oVirt or by other vendors.
     * See https://www.dmtf.org/standards/ovf[here] for the OVF specification.
     *
     * @author Arik Hadas <ahadas@redhat.com>
     * @author Tahlia Richardson <trichard@redhat.com>
     * @date 09 Nov 2017
     * @status updated_by_docs
     * @since 4.2
     */
    OVA;
}
