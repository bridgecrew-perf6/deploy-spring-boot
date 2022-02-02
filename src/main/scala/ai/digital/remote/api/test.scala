package ai.digital.remote.api

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.xebialabs.deployit.engine.tasker.BlockExecutingActor.BlockDone
import com.xebialabs.deployit.engine.tasker.{BlockPath, StepBlock, TaskStep}
import com.xebialabs.deployit.plugin.steps.NoopStep
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.http.{HttpEntity, HttpHeaders, MediaType}
import org.springframework.util.SerializationUtils
import org.springframework.web.client.RestTemplate

import scala.collection.mutable.ListBuffer

object test {

  val restTemplate: RestTemplate = {
    val objectMapper = new ObjectMapper()
    objectMapper.registerModule(DefaultScalaModule)
    // objectMapper.registerModule(new JavaTimeModule())

    val mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter(objectMapper)
    val restTemplate = new RestTemplate

    restTemplate.getMessageConverters.removeIf(
      m => m.getClass.getName.equals(classOf[MappingJackson2HttpMessageConverter].getName))
    restTemplate.getMessageConverters.add(mappingJackson2HttpMessageConverter)
    restTemplate
  }
  val headers = new HttpHeaders
  headers.setContentType(MediaType.APPLICATION_JSON)

  def main(args: Array[String]) = {
    val stepState = new TaskStep(new NoopStep())
    val stepBlock = StepBlock(BlockPath(List(0,2,1,2)), "", None, ListBuffer(stepState))

    val blockDone = BlockDone("fd90b81c-6208-4490-b83b-bb0488fad66a", stepBlock)
//    val result = StepBlockWrapper(blockDone.block.id, blockDone.block.description, None, blockDone.block.getStepList())
    val bytes = SerializationUtils.serialize(blockDone)

    val status = restTemplate.postForObject("http://localhost:8080/deploy/remote/block",
      new HttpEntity[BlockDoneWrapper](BlockDoneWrapper(blockDone.taskId, bytes), headers), classOf[String])

  }

}
