package controllers

import com.google.inject.Inject
import com.gu.googleauth.{GoogleAuthConfig, LoginSupport}
import play.api.libs.ws.WSClient
import play.api.mvc.{AbstractController, Action, AnyContent, Call, ControllerComponents}

import scala.concurrent.ExecutionContext

class GoogleAuthController @Inject() (val authConfig: GoogleAuthConfig, controllerComponents: ControllerComponents)(implicit
    override val wsClient: WSClient,
    ec: ExecutionContext
) extends AbstractController(controllerComponents)
    with LoginSupport {

  def loginAction: Action[AnyContent] = Action.async { implicit request =>
    startGoogleLogin()
  }

  def oauth2Callback: Action[AnyContent] = Action.async { implicit request =>
    processOauth2Callback()
  }

  def logout: Action[AnyContent] = Action { implicit request =>
    Redirect(routes.HomeController.index()).withNewSession
  }

  override val failureRedirectTarget: Call = routes.GoogleAuthController.loginAction
  override val defaultRedirectTarget: Call = routes.HomeController.index()
}
