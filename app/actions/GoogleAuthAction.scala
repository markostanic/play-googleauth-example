package actions

import com.google.inject.Inject
import com.gu.googleauth.{AuthAction, GoogleAuthConfig}
import controllers.routes
import play.api.mvc.BodyParsers

import scala.concurrent.ExecutionContext

class GoogleAuthAction @Inject() (parser: BodyParsers.Default, override val authConfig: GoogleAuthConfig)(implicit
    ec: ExecutionContext
) extends AuthAction(authConfig, loginTarget = routes.GoogleAuthController.loginAction, parser) {}
