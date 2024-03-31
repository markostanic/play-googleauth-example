package controllers

import actions.GoogleAuthAction
import play.api.libs.json.Json
import play.api.mvc._

import javax.inject._

/** This controller creates an `Action` to handle HTTP requests to the
  * application's home page.
  */
@Singleton
class HomeController @Inject() (val controllerComponents: ControllerComponents, authAction: GoogleAuthAction) extends BaseController {

  def index(): Action[AnyContent] = authAction { implicit request =>
    Ok(Json.toJson(request.user))
  }

}
