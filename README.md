# xld-upgrade-test
This repository uses the integration-server-gradle-plugin to 
upgrade the latest version of Deploy from a previous version and tests for configuration values
post upgrade.

For now, it tests only the Client Configuration Settings using the internal API provided by Deploy - deployit/internal/configuration/properties

use the below command to run the test which will in turn run the integration server with the upgrades
``
gradlew testClientSettings
``
