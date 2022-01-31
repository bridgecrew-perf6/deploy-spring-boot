package ai.digital.remote.api

import org.springframework.web.bind.annotation.{GetMapping, RestController}

import scala.jdk.CollectionConverters._

@RestController
@GetMapping(Array("/deploy/remote"))
class BlockController {

  @GetMapping(Array("/block"))
  def getBlock = {
    new StartBlockWrapper("fd90b81c-6208-4490-b83b-bb0488fad66a", List(0,2,1,2).asJava)
  }
}
