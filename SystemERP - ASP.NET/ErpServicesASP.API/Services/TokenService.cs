using ErpServicesASP.API.Model;
using ErpServicesASP.API.Services.Interfaces;
using Microsoft.IdentityModel.Tokens;
using System.IdentityModel.Tokens.Jwt;

namespace ErpServicesASP.API.Services
{
    public class TokenService : ITokenInterface
    {
        private readonly string _secretKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkV4ZW1wbG8gVXN1YXJpbyIsImlhdCI6MTYxNjIwMDAwMH0SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c";
        public string GenerateToken(UserModel user)
        {
            var key = System.Text.Encoding.UTF8.GetBytes(_secretKey);
            var tokenHandler = new JwtSecurityTokenHandler();
            var tokenDescriptor = new SecurityTokenDescriptor
            {
                Subject = new System.Security.Claims.ClaimsIdentity(new[]
                {
                    new System.Security.Claims.Claim("IdUser", user.IdUser.ToString()),
                    new System.Security.Claims.Claim("Name", user.Name)
                }),
                Expires = DateTime.UtcNow.AddHours(1),
                SigningCredentials = new SigningCredentials(
                    new SymmetricSecurityKey(key),
                    SecurityAlgorithms.HmacSha256Signature
                )
            };
            var token = tokenHandler.CreateToken(tokenDescriptor);
            return tokenHandler.WriteToken(token);
        }
    }
}
