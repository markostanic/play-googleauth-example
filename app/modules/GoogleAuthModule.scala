package modules

import com.google.inject.{AbstractModule, Provides}
import com.gu.googleauth.{AntiForgeryChecker, AuthAction, GoogleAuthConfig}
import com.gu.play.secretrotation.DualSecretTransition.{InitialSecret, TransitioningSecret}
import controllers.routes
import play.api.Configuration
import play.api.http.HttpConfiguration
import play.api.mvc.AnyContent

import scala.concurrent.ExecutionContext

class GoogleAuthModule extends AbstractModule {

  @Provides
  def provideAntiForgeryChecker(httpConfiguration: HttpConfiguration): AntiForgeryChecker = {
    val signatureAlg = AntiForgeryChecker.signatureAlgorithmFromPlay(httpConfiguration)
    val secret = InitialSecret(httpConfiguration.secret.secret)
    AntiForgeryChecker(secret, signatureAlg)
  }

  @Provides
  def provideGoogleAuthConfig(configuration: Configuration, antiForgeryChecker: AntiForgeryChecker): GoogleAuthConfig = {
    GoogleAuthConfig(
      clientId = configuration.get[String]("auth.clientId"),
      clientSecret = configuration.get[String]("auth.clientSecret"),
      redirectUrl = configuration.get[String]("auth.redirectUrl"),
      domains = configuration.get[Seq[String]]("auth.domains").toList,
      antiForgeryChecker = antiForgeryChecker
    )
  }

}
