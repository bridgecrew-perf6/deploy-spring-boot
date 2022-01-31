package ai.digital.remote

import com.xebialabs.deployit.engine.tasker.TaskId
import com.xebialabs.satellite.protocol.TaskSpecificationExchange.{ArtifactType, StepType}

package object api {
  class TaskSpecificationExchangeWrapper(
                                          stepTypes: java.util.List[StepType],
                                          taskBytes: Array[Byte],
                                          taskId: TaskId,
                                          fileIds: java.util.Set[String],
                                          artifactTypes: java.util.List[ArtifactType]) {

    def this() = {
      this(null, null, null, null, null)
    }

    def getStepTypes = stepTypes

    def getTaskBytes = taskBytes

    def getTaskId = taskId

    def getFileIds = fileIds

    def getArtifactTypes = artifactTypes

  }

  class StartBlockWrapper(taskId: TaskId, paths: java.util.List[Int]) {
    def this() = {
      this(null, null)
    }

    def getTaskId= taskId

    def getPaths = paths
  }

}
