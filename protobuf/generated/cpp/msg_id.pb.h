// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: msg_id.proto

#ifndef PROTOBUF_msg_5fid_2eproto__INCLUDED
#define PROTOBUF_msg_5fid_2eproto__INCLUDED

#include <string>

#include <google/protobuf/stubs/common.h>

#if GOOGLE_PROTOBUF_VERSION < 2005000
#error This file was generated by a newer version of protoc which is
#error incompatible with your Protocol Buffer headers.  Please update
#error your headers.
#endif
#if 2005000 < GOOGLE_PROTOBUF_MIN_PROTOC_VERSION
#error This file was generated by an older version of protoc which is
#error incompatible with your Protocol Buffer headers.  Please
#error regenerate this file with a newer version of protoc.
#endif

#include <google/protobuf/generated_message_util.h>
#include <google/protobuf/repeated_field.h>
#include <google/protobuf/extension_set.h>
// @@protoc_insertion_point(includes)

namespace netty {

// Internal implementation detail -- do not call these.
void  protobuf_AddDesc_msg_5fid_2eproto();
void protobuf_AssignDesc_msg_5fid_2eproto();
void protobuf_ShutdownFile_msg_5fid_2eproto();


enum MsgID {
  MESSAGER = 1,
  TEST = 2
};
bool MsgID_IsValid(int value);
const MsgID MsgID_MIN = MESSAGER;
const MsgID MsgID_MAX = TEST;
const int MsgID_ARRAYSIZE = MsgID_MAX + 1;

// ===================================================================


// ===================================================================


// ===================================================================


// @@protoc_insertion_point(namespace_scope)

}  // namespace netty

// @@protoc_insertion_point(global_scope)

#endif  // PROTOBUF_msg_5fid_2eproto__INCLUDED