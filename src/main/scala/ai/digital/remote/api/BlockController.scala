package ai.digital.remote.api

import org.springframework.util.SerializationUtils
import org.springframework.web.bind.annotation.{GetMapping, PostMapping, RequestBody, RestController}

import javax.ws.rs.core.MediaType

@RestController
@GetMapping(Array("/deploy/remote"))
class BlockController {

  @GetMapping(Array("/block"))
  def getBlock = {
    new StartBlockWrapper("fd90b81c-6208-4490-b83b-bb0488fad66a", List(0,2,1,2))
  }

  @PostMapping(path = Array("/block"), consumes = Array(MediaType.APPLICATION_JSON))
  def blockDone(@RequestBody blockDone: BlockDoneWrapper) = {
    val block = SerializationUtils.deserialize(blockDone.bytes)
    println(s"the blockDone state - $blockDone")
  }
}
