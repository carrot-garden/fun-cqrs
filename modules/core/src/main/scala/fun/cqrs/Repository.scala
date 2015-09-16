package fun.cqrs

import scala.concurrent.{ExecutionContext, Future}

trait Repository {

  type Model
  type Identifier

  def find(id: Identifier)(implicit ec: ExecutionContext): Future[Model]

  def save(model: Model)(implicit ec: ExecutionContext): Future[Unit]

  def updateById(id: Identifier)(updateFunc: Model => Model)(implicit ec: ExecutionContext): Future[Model]
}