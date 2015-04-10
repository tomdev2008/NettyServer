// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: test.proto

#define INTERNAL_SUPPRESS_PROTOBUF_FIELD_DEPRECATION
#include "test.pb.h"

#include <algorithm>

#include <google/protobuf/stubs/common.h>
#include <google/protobuf/stubs/once.h>
#include <google/protobuf/io/coded_stream.h>
#include <google/protobuf/wire_format_lite_inl.h>
// @@protoc_insertion_point(includes)

namespace netty {

void protobuf_ShutdownFile_test_2eproto() {
  delete TestRequest::default_instance_;
  delete TestResponse::default_instance_;
}

#ifdef GOOGLE_PROTOBUF_NO_STATIC_INITIALIZER
void protobuf_AddDesc_test_2eproto_impl() {
  GOOGLE_PROTOBUF_VERIFY_VERSION;

#else
void protobuf_AddDesc_test_2eproto() {
  static bool already_here = false;
  if (already_here) return;
  already_here = true;
  GOOGLE_PROTOBUF_VERIFY_VERSION;

#endif
  ::netty::protobuf_AddDesc_msg_5fid_2eproto();
  TestRequest::default_instance_ = new TestRequest();
  TestResponse::default_instance_ = new TestResponse();
  TestRequest::default_instance_->InitAsDefaultInstance();
  TestResponse::default_instance_->InitAsDefaultInstance();
  ::google::protobuf::internal::OnShutdown(&protobuf_ShutdownFile_test_2eproto);
}

#ifdef GOOGLE_PROTOBUF_NO_STATIC_INITIALIZER
GOOGLE_PROTOBUF_DECLARE_ONCE(protobuf_AddDesc_test_2eproto_once_);
void protobuf_AddDesc_test_2eproto() {
  ::google::protobuf::::google::protobuf::GoogleOnceInit(&protobuf_AddDesc_test_2eproto_once_,
                 &protobuf_AddDesc_test_2eproto_impl);
}
#else
// Force AddDescriptors() to be called at static initialization time.
struct StaticDescriptorInitializer_test_2eproto {
  StaticDescriptorInitializer_test_2eproto() {
    protobuf_AddDesc_test_2eproto();
  }
} static_descriptor_initializer_test_2eproto_;
#endif

// ===================================================================

#ifndef _MSC_VER
const int TestRequest::kMsgIDFieldNumber;
const int TestRequest::kData1FieldNumber;
const int TestRequest::kData2FieldNumber;
#endif  // !_MSC_VER

TestRequest::TestRequest()
  : ::google::protobuf::MessageLite() {
  SharedCtor();
}

void TestRequest::InitAsDefaultInstance() {
}

TestRequest::TestRequest(const TestRequest& from)
  : ::google::protobuf::MessageLite() {
  SharedCtor();
  MergeFrom(from);
}

void TestRequest::SharedCtor() {
  _cached_size_ = 0;
  msgid_ = 1;
  data1_ = 0;
  data2_ = 0;
  ::memset(_has_bits_, 0, sizeof(_has_bits_));
}

TestRequest::~TestRequest() {
  SharedDtor();
}

void TestRequest::SharedDtor() {
  #ifdef GOOGLE_PROTOBUF_NO_STATIC_INITIALIZER
  if (this != &default_instance()) {
  #else
  if (this != default_instance_) {
  #endif
  }
}

void TestRequest::SetCachedSize(int size) const {
  GOOGLE_SAFE_CONCURRENT_WRITES_BEGIN();
  _cached_size_ = size;
  GOOGLE_SAFE_CONCURRENT_WRITES_END();
}
const TestRequest& TestRequest::default_instance() {
#ifdef GOOGLE_PROTOBUF_NO_STATIC_INITIALIZER
  protobuf_AddDesc_test_2eproto();
#else
  if (default_instance_ == NULL) protobuf_AddDesc_test_2eproto();
#endif
  return *default_instance_;
}

TestRequest* TestRequest::default_instance_ = NULL;

TestRequest* TestRequest::New() const {
  return new TestRequest;
}

void TestRequest::Clear() {
  if (_has_bits_[0 / 32] & (0xffu << (0 % 32))) {
    msgid_ = 1;
    data1_ = 0;
    data2_ = 0;
  }
  ::memset(_has_bits_, 0, sizeof(_has_bits_));
}

bool TestRequest::MergePartialFromCodedStream(
    ::google::protobuf::io::CodedInputStream* input) {
#define DO_(EXPRESSION) if (!(EXPRESSION)) return false
  ::google::protobuf::uint32 tag;
  while ((tag = input->ReadTag()) != 0) {
    switch (::google::protobuf::internal::WireFormatLite::GetTagFieldNumber(tag)) {
      // required .netty.MsgID msgID = 1;
      case 1: {
        if (::google::protobuf::internal::WireFormatLite::GetTagWireType(tag) ==
            ::google::protobuf::internal::WireFormatLite::WIRETYPE_VARINT) {
          int value;
          DO_((::google::protobuf::internal::WireFormatLite::ReadPrimitive<
                   int, ::google::protobuf::internal::WireFormatLite::TYPE_ENUM>(
                 input, &value)));
          if (::netty::MsgID_IsValid(value)) {
            set_msgid(static_cast< ::netty::MsgID >(value));
          }
        } else {
          goto handle_uninterpreted;
        }
        if (input->ExpectTag(16)) goto parse_data1;
        break;
      }

      // optional int32 data1 = 2;
      case 2: {
        if (::google::protobuf::internal::WireFormatLite::GetTagWireType(tag) ==
            ::google::protobuf::internal::WireFormatLite::WIRETYPE_VARINT) {
         parse_data1:
          DO_((::google::protobuf::internal::WireFormatLite::ReadPrimitive<
                   ::google::protobuf::int32, ::google::protobuf::internal::WireFormatLite::TYPE_INT32>(
                 input, &data1_)));
          set_has_data1();
        } else {
          goto handle_uninterpreted;
        }
        if (input->ExpectTag(24)) goto parse_data2;
        break;
      }

      // optional int32 data2 = 3;
      case 3: {
        if (::google::protobuf::internal::WireFormatLite::GetTagWireType(tag) ==
            ::google::protobuf::internal::WireFormatLite::WIRETYPE_VARINT) {
         parse_data2:
          DO_((::google::protobuf::internal::WireFormatLite::ReadPrimitive<
                   ::google::protobuf::int32, ::google::protobuf::internal::WireFormatLite::TYPE_INT32>(
                 input, &data2_)));
          set_has_data2();
        } else {
          goto handle_uninterpreted;
        }
        if (input->ExpectAtEnd()) return true;
        break;
      }

      default: {
      handle_uninterpreted:
        if (::google::protobuf::internal::WireFormatLite::GetTagWireType(tag) ==
            ::google::protobuf::internal::WireFormatLite::WIRETYPE_END_GROUP) {
          return true;
        }
        DO_(::google::protobuf::internal::WireFormatLite::SkipField(input, tag));
        break;
      }
    }
  }
  return true;
#undef DO_
}

void TestRequest::SerializeWithCachedSizes(
    ::google::protobuf::io::CodedOutputStream* output) const {
  // required .netty.MsgID msgID = 1;
  if (has_msgid()) {
    ::google::protobuf::internal::WireFormatLite::WriteEnum(
      1, this->msgid(), output);
  }

  // optional int32 data1 = 2;
  if (has_data1()) {
    ::google::protobuf::internal::WireFormatLite::WriteInt32(2, this->data1(), output);
  }

  // optional int32 data2 = 3;
  if (has_data2()) {
    ::google::protobuf::internal::WireFormatLite::WriteInt32(3, this->data2(), output);
  }

}

int TestRequest::ByteSize() const {
  int total_size = 0;

  if (_has_bits_[0 / 32] & (0xffu << (0 % 32))) {
    // required .netty.MsgID msgID = 1;
    if (has_msgid()) {
      total_size += 1 +
        ::google::protobuf::internal::WireFormatLite::EnumSize(this->msgid());
    }

    // optional int32 data1 = 2;
    if (has_data1()) {
      total_size += 1 +
        ::google::protobuf::internal::WireFormatLite::Int32Size(
          this->data1());
    }

    // optional int32 data2 = 3;
    if (has_data2()) {
      total_size += 1 +
        ::google::protobuf::internal::WireFormatLite::Int32Size(
          this->data2());
    }

  }
  GOOGLE_SAFE_CONCURRENT_WRITES_BEGIN();
  _cached_size_ = total_size;
  GOOGLE_SAFE_CONCURRENT_WRITES_END();
  return total_size;
}

void TestRequest::CheckTypeAndMergeFrom(
    const ::google::protobuf::MessageLite& from) {
  MergeFrom(*::google::protobuf::down_cast<const TestRequest*>(&from));
}

void TestRequest::MergeFrom(const TestRequest& from) {
  GOOGLE_CHECK_NE(&from, this);
  if (from._has_bits_[0 / 32] & (0xffu << (0 % 32))) {
    if (from.has_msgid()) {
      set_msgid(from.msgid());
    }
    if (from.has_data1()) {
      set_data1(from.data1());
    }
    if (from.has_data2()) {
      set_data2(from.data2());
    }
  }
}

void TestRequest::CopyFrom(const TestRequest& from) {
  if (&from == this) return;
  Clear();
  MergeFrom(from);
}

bool TestRequest::IsInitialized() const {
  if ((_has_bits_[0] & 0x00000001) != 0x00000001) return false;

  return true;
}

void TestRequest::Swap(TestRequest* other) {
  if (other != this) {
    std::swap(msgid_, other->msgid_);
    std::swap(data1_, other->data1_);
    std::swap(data2_, other->data2_);
    std::swap(_has_bits_[0], other->_has_bits_[0]);
    std::swap(_cached_size_, other->_cached_size_);
  }
}

::std::string TestRequest::GetTypeName() const {
  return "netty.TestRequest";
}


// ===================================================================

#ifndef _MSC_VER
const int TestResponse::kMsgIDFieldNumber;
const int TestResponse::kData1FieldNumber;
const int TestResponse::kData2FieldNumber;
#endif  // !_MSC_VER

TestResponse::TestResponse()
  : ::google::protobuf::MessageLite() {
  SharedCtor();
}

void TestResponse::InitAsDefaultInstance() {
}

TestResponse::TestResponse(const TestResponse& from)
  : ::google::protobuf::MessageLite() {
  SharedCtor();
  MergeFrom(from);
}

void TestResponse::SharedCtor() {
  _cached_size_ = 0;
  msgid_ = 1;
  data1_ = 0;
  data2_ = 0;
  ::memset(_has_bits_, 0, sizeof(_has_bits_));
}

TestResponse::~TestResponse() {
  SharedDtor();
}

void TestResponse::SharedDtor() {
  #ifdef GOOGLE_PROTOBUF_NO_STATIC_INITIALIZER
  if (this != &default_instance()) {
  #else
  if (this != default_instance_) {
  #endif
  }
}

void TestResponse::SetCachedSize(int size) const {
  GOOGLE_SAFE_CONCURRENT_WRITES_BEGIN();
  _cached_size_ = size;
  GOOGLE_SAFE_CONCURRENT_WRITES_END();
}
const TestResponse& TestResponse::default_instance() {
#ifdef GOOGLE_PROTOBUF_NO_STATIC_INITIALIZER
  protobuf_AddDesc_test_2eproto();
#else
  if (default_instance_ == NULL) protobuf_AddDesc_test_2eproto();
#endif
  return *default_instance_;
}

TestResponse* TestResponse::default_instance_ = NULL;

TestResponse* TestResponse::New() const {
  return new TestResponse;
}

void TestResponse::Clear() {
  if (_has_bits_[0 / 32] & (0xffu << (0 % 32))) {
    msgid_ = 1;
    data1_ = 0;
    data2_ = 0;
  }
  ::memset(_has_bits_, 0, sizeof(_has_bits_));
}

bool TestResponse::MergePartialFromCodedStream(
    ::google::protobuf::io::CodedInputStream* input) {
#define DO_(EXPRESSION) if (!(EXPRESSION)) return false
  ::google::protobuf::uint32 tag;
  while ((tag = input->ReadTag()) != 0) {
    switch (::google::protobuf::internal::WireFormatLite::GetTagFieldNumber(tag)) {
      // required .netty.MsgID msgID = 1;
      case 1: {
        if (::google::protobuf::internal::WireFormatLite::GetTagWireType(tag) ==
            ::google::protobuf::internal::WireFormatLite::WIRETYPE_VARINT) {
          int value;
          DO_((::google::protobuf::internal::WireFormatLite::ReadPrimitive<
                   int, ::google::protobuf::internal::WireFormatLite::TYPE_ENUM>(
                 input, &value)));
          if (::netty::MsgID_IsValid(value)) {
            set_msgid(static_cast< ::netty::MsgID >(value));
          }
        } else {
          goto handle_uninterpreted;
        }
        if (input->ExpectTag(16)) goto parse_data1;
        break;
      }

      // optional int32 data1 = 2;
      case 2: {
        if (::google::protobuf::internal::WireFormatLite::GetTagWireType(tag) ==
            ::google::protobuf::internal::WireFormatLite::WIRETYPE_VARINT) {
         parse_data1:
          DO_((::google::protobuf::internal::WireFormatLite::ReadPrimitive<
                   ::google::protobuf::int32, ::google::protobuf::internal::WireFormatLite::TYPE_INT32>(
                 input, &data1_)));
          set_has_data1();
        } else {
          goto handle_uninterpreted;
        }
        if (input->ExpectTag(24)) goto parse_data2;
        break;
      }

      // optional int32 data2 = 3;
      case 3: {
        if (::google::protobuf::internal::WireFormatLite::GetTagWireType(tag) ==
            ::google::protobuf::internal::WireFormatLite::WIRETYPE_VARINT) {
         parse_data2:
          DO_((::google::protobuf::internal::WireFormatLite::ReadPrimitive<
                   ::google::protobuf::int32, ::google::protobuf::internal::WireFormatLite::TYPE_INT32>(
                 input, &data2_)));
          set_has_data2();
        } else {
          goto handle_uninterpreted;
        }
        if (input->ExpectAtEnd()) return true;
        break;
      }

      default: {
      handle_uninterpreted:
        if (::google::protobuf::internal::WireFormatLite::GetTagWireType(tag) ==
            ::google::protobuf::internal::WireFormatLite::WIRETYPE_END_GROUP) {
          return true;
        }
        DO_(::google::protobuf::internal::WireFormatLite::SkipField(input, tag));
        break;
      }
    }
  }
  return true;
#undef DO_
}

void TestResponse::SerializeWithCachedSizes(
    ::google::protobuf::io::CodedOutputStream* output) const {
  // required .netty.MsgID msgID = 1;
  if (has_msgid()) {
    ::google::protobuf::internal::WireFormatLite::WriteEnum(
      1, this->msgid(), output);
  }

  // optional int32 data1 = 2;
  if (has_data1()) {
    ::google::protobuf::internal::WireFormatLite::WriteInt32(2, this->data1(), output);
  }

  // optional int32 data2 = 3;
  if (has_data2()) {
    ::google::protobuf::internal::WireFormatLite::WriteInt32(3, this->data2(), output);
  }

}

int TestResponse::ByteSize() const {
  int total_size = 0;

  if (_has_bits_[0 / 32] & (0xffu << (0 % 32))) {
    // required .netty.MsgID msgID = 1;
    if (has_msgid()) {
      total_size += 1 +
        ::google::protobuf::internal::WireFormatLite::EnumSize(this->msgid());
    }

    // optional int32 data1 = 2;
    if (has_data1()) {
      total_size += 1 +
        ::google::protobuf::internal::WireFormatLite::Int32Size(
          this->data1());
    }

    // optional int32 data2 = 3;
    if (has_data2()) {
      total_size += 1 +
        ::google::protobuf::internal::WireFormatLite::Int32Size(
          this->data2());
    }

  }
  GOOGLE_SAFE_CONCURRENT_WRITES_BEGIN();
  _cached_size_ = total_size;
  GOOGLE_SAFE_CONCURRENT_WRITES_END();
  return total_size;
}

void TestResponse::CheckTypeAndMergeFrom(
    const ::google::protobuf::MessageLite& from) {
  MergeFrom(*::google::protobuf::down_cast<const TestResponse*>(&from));
}

void TestResponse::MergeFrom(const TestResponse& from) {
  GOOGLE_CHECK_NE(&from, this);
  if (from._has_bits_[0 / 32] & (0xffu << (0 % 32))) {
    if (from.has_msgid()) {
      set_msgid(from.msgid());
    }
    if (from.has_data1()) {
      set_data1(from.data1());
    }
    if (from.has_data2()) {
      set_data2(from.data2());
    }
  }
}

void TestResponse::CopyFrom(const TestResponse& from) {
  if (&from == this) return;
  Clear();
  MergeFrom(from);
}

bool TestResponse::IsInitialized() const {
  if ((_has_bits_[0] & 0x00000001) != 0x00000001) return false;

  return true;
}

void TestResponse::Swap(TestResponse* other) {
  if (other != this) {
    std::swap(msgid_, other->msgid_);
    std::swap(data1_, other->data1_);
    std::swap(data2_, other->data2_);
    std::swap(_has_bits_[0], other->_has_bits_[0]);
    std::swap(_cached_size_, other->_cached_size_);
  }
}

::std::string TestResponse::GetTypeName() const {
  return "netty.TestResponse";
}


// @@protoc_insertion_point(namespace_scope)

}  // namespace netty

// @@protoc_insertion_point(global_scope)