package ai.digital.remote

import com.xebialabs.deployit.engine.api.execution.StepState
import com.xebialabs.deployit.engine.tasker.{BlockPath, Description, TaskId}
import com.xebialabs.satellite.protocol.TaskSpecificationExchange.{ArtifactType, StepType}
import com.xebialabs.xlplatform.satellite.Satellite

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

  class StartBlockWrapper(taskId: TaskId, paths: List[Int]) {
    def this() = {
      this(null, null)
    }

    def getTaskId= taskId

    def getPaths = paths
  }

  case class BlockDoneWrapper(taskId: TaskId, bytes: Array[Byte])

  case class StepBlockWrapper(id: BlockPath, description: Description, satellite: Option[Satellite], var steps: java.util.List[StepState])
}
