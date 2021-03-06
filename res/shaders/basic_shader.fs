#version 330 core

in vec2 pass_texCoord;
in vec3 pass_color;

out vec4 out_fragColor;

uniform sampler2D sampler;

void main()
{
	out_fragColor = vec4(pass_color, 1.0);
	//out_fragColor = texture(sampler, pass_texCoord.xy);
}